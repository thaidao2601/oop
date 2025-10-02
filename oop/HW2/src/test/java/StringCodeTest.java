// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;


public class StringCodeTest {

	//
	// blowup
	//
	@Test
	public void testBlowup_BasicCases() {
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}

	@Test
	public void testBlowup_DigitAtEnd() {
		assertEquals("axxx", StringCode.blowup("a2x3"));
	}

	@Test
	public void testBlowup_DigitsNextToEachOther() {
		assertEquals("a33111", StringCode.blowup("a231"));
	}

	@Test
	public void testBlowup_DigitZero() {
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}

	@Test
	public void testBlowup_DigitsOnly() {
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
	}

	@Test
	public void testBlowup_WeirdChars() {
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));
	}
	
	
	//
	// maxRun
	//
	@Test
	public void testMaxRun_BasicCases() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}

	@Test
	public void testMaxRun_LongestAtEnd() {
		assertEquals(3, StringCode.maxRun("hooplaaa"));
		assertEquals(3, StringCode.maxRun("hooplllaaa"));
	}

	@Test
	public void testMaxRun_LongestAtBeginning() {
		assertEquals(3, StringCode.maxRun("hhhooplaa"));
		assertEquals(4, StringCode.maxRun("hhhhooplllaaa"));
	}

	@Test
	public void testMaxRun_SpecialCases() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals("empty string", 0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
	}

	@Test
	public void testMaxRun_NotSureWhyNeeded() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}

	// Need test cases for stringIntersect
    @Test
    public void testStringIntersect_BasicCases() {
        assertTrue(StringCode.stringIntersect("abcdef", "zcdemf", 3)); // "cde"
        assertFalse(StringCode.stringIntersect("abcdef", "ghijkl", 2)); // không có chung
    }

    @Test
    public void testStringIntersect_OverlapAtBeginning() {
        assertTrue(StringCode.stringIntersect("hello", "heyy", 2)); // "he"
        assertFalse(StringCode.stringIntersect("hello", "heyy", 3)); // không có "hel" trong heyy
    }

    @Test
    public void testStringIntersect_OverlapAtEnd() {
        assertTrue(StringCode.stringIntersect("abcdxyz", "wxyz", 3)); // "xyz"
        assertFalse(StringCode.stringIntersect("abcdxyz", "wxyz", 4)); // không có "dxyz" trong wxyz
    }

    @Test
    public void testStringIntersect_SameStrings() {
        assertTrue(StringCode.stringIntersect("banana", "banana", 6)); // nguyên chuỗi
        assertTrue(StringCode.stringIntersect("banana", "banana", 1)); // bất kỳ ký tự nào
    }

    @Test
    public void testStringIntersect_SpecialCases() {
        assertFalse("len lớn hơn độ dài chuỗi", StringCode.stringIntersect("abc", "abc", 5));
        assertFalse("một chuỗi rỗng", StringCode.stringIntersect("", "abc", 1));
        assertFalse("cả 2 chuỗi rỗng", StringCode.stringIntersect("", "", 1));
    }
}
