package com.angle.exception;

import java.lang.management.ManagementFactory;
import java.util.regex.Pattern;

/**
 * 简单的契约类, 以后得增强.
 * 
 * @author Lucifer
 * 
 */
public abstract class Contract {

	public static void asserts(boolean b) {
		// assert b;
		if (!b && isDebugging())
			throw new AssertionException();
	}

	public static void ensures(boolean b) {
		if (!b)
			throw new PostConditionException();
	}

	public static void requires(boolean b) {
		if (!b) {
			throw new PreconditionException();
		}
	}

	private final static Pattern debugPattern = Pattern.compile("-Xdebubg|jdwp");

	public static boolean isDebugging() {
		for (String arg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
			if (debugPattern.matcher(arg).find()) {
				return true;
			}
		}
		return false;
	}
}
