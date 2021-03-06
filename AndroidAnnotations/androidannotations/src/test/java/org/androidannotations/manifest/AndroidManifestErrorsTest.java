/**
 * Copyright (C) 2010-2015 eBusiness Information, Excilys Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.androidannotations.manifest;

import java.io.IOException;

import org.androidannotations.AndroidAnnotationProcessor;
import org.androidannotations.utils.AAProcessorTestHelper;
import org.junit.Before;
import org.junit.Test;

public class AndroidManifestErrorsTest extends AAProcessorTestHelper {

	@Before
	public void setUp() {
		addManifestProcessorParameter(AndroidManifestErrorsTest.class);
		addProcessor(AndroidAnnotationProcessor.class);
	}

	@Test
	public void activitySubclassInManifestCompiles() {
		CompileResult result = compileFiles(ActivitySubclassInManifest.class);
		assertCompilationSuccessful(result);
	}

	@Test
	public void activityInManifestDoesNotCompile() throws IOException {
		CompileResult result = compileFiles(ActivityInManifest.class);
		assertCompilationErrorOn(ActivityInManifest.class, "@EActivity", result);
	}

	@Test
	public void activityNotInManifestCompilesWithWarning() throws IOException {
		CompileResult result = compileFiles(ActivityNotInManifest.class);
		assertCompilationWarningOn(ActivityNotInManifest.class, "@EActivity", result);
	}
}
