/*
 * Copyright 2009 Marc-Olaf Jaschke
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.jkeylockmanager.contract;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * 
 * @author Marc-Olaf Jaschke
 * 
 */
public class ContractTest {

	private static final String MESSAGE = "message";

	@Test
	public void testAssertIsTrue() throws Exception {

		Contract.isTrue(true, MESSAGE);

		try {
			Contract.isTrue(false, MESSAGE);
			fail();
		} catch (final ContractBrokenError e) {
			assertEquals(String.format("contract broken: %s", MESSAGE), e.getMessage());
		}

	}

	@Test
	public void testAssertNotNull() throws Exception {

		Contract.isNotNull("", MESSAGE);

		try {
			Contract.isNotNull(null, MESSAGE);
			fail();
		} catch (final ContractBrokenError e) {
			assertEquals(String.format("contract broken: %s", MESSAGE), e.getMessage());
		}

	}
}
