/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.devtools.j2objc.javac;

import com.google.devtools.j2objc.GenerationTest;

/** Tests for {@link JavacParser}. */
public class JavacParserTest extends GenerationTest {

  public void testPackageName() {
    String source =
        String.join(
            "\n",
            "/* A comment with a package name.*/",
            "// Another comment with a package a.b.c;",
            "@com.google.j2objc.annotations.ObjectiveCName(\"package\")",
            "package foo.bar;",
            "class Test {}");
    assertEquals("foo.bar", JavacParser.packageName(source));
  }

  public void testPackageNameWithUnusualCharacters() {
    String source = "package foo$bar.all_mumbles;";
    assertEquals("foo$bar.all_mumbles", JavacParser.packageName(source));
  }
}
