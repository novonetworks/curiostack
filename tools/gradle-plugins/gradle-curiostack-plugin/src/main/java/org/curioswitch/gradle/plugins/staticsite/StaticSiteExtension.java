/*
 * MIT License
 *
 * Copyright (c) 2019 Choko (choko@curioswitch.org)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.curioswitch.gradle.plugins.staticsite;

import java.nio.file.Path;
import org.curioswitch.common.helpers.immutables.CurioStyle;
import org.curioswitch.gradle.helpers.immutables.ExtensionStyle;
import org.gradle.api.Project;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.reflect.HasPublicType;
import org.gradle.api.reflect.TypeOf;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Modifiable;

@Modifiable
@ExtensionStyle
public interface StaticSiteExtension extends HasPublicType {

  String NAME = "staticSite";

  static StaticSiteExtension create(Project project) {
    var objects = project.getObjects();

    var extension =
        project
            .getExtensions()
            .create(NAME, ModifiableStaticSiteExtension.class)
            .setFirebaseProject(objects.property(String.class))
            .setAutoDeployAlpha(objects.property(Boolean.class).convention(true))
            .setSites(objects.listProperty(SiteProject.class).empty());
    extension.setAppEngineProject(
        objects.property(String.class).convention(extension.getFirebaseProject()));

    return extension;
  }

  Property<String> getFirebaseProject();

  Property<String> getAppEngineProject();

  Property<Boolean> getAutoDeployAlpha();

  @Immutable
  @CurioStyle
  interface SiteProject {
    Project getProject();

    String getOutputSubDir();

    Path getBuildDir();
  }

  ListProperty<SiteProject> getSites();

  default StaticSiteExtension site(Project project, String outputSubDir) {
    return site(project, outputSubDir, "build/site");
  }

  default StaticSiteExtension site(Project project, String outputSubDir, Object buildDir) {
    Path outputPath = project.file(buildDir).toPath();
    getSites()
        .add(
            ImmutableSiteProject.builder()
                .project(project)
                .outputSubDir(outputSubDir)
                .buildDir(outputPath)
                .build());
    return this;
  }

  @Override
  default TypeOf<?> getPublicType() {
    return TypeOf.typeOf(StaticSiteExtension.class);
  }
}
