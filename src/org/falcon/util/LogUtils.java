package org.falcon.util;

public class LogUtils {

    @SuppressWarnings("FieldHasSetterButNoGetter")
    private String name;

    @SuppressWarnings("FieldHasSetterButNoGetter")
    private int value;

    private static boolean debugger = true;

    public static final LogUtils ERROR = new LogUtils("ERROR", 31);
    public static final LogUtils SUCCESS = new LogUtils("SUCCESS", 32);
    public static final LogUtils WARNING = new LogUtils("WARNING", 33);
    public static final LogUtils INFO = new LogUtils("INFO", 34);
    public static final LogUtils NORMAL = new LogUtils("NORMAL", 38);

    public LogUtils() {
    }

    public LogUtils(String var1, int value) {
        if(var1 == null) {
            throw new NullPointerException();
        } else {
            setName(var1);
            setValue(value);
        }
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setValue(int i) {
        this.value = i;
    }

    public static String setUp(LogUtils logUtils) {
        return ConsoleUtils.color(logUtils.value);
    }

    public static String setUp(LogUtils logUtils, boolean b) {
        if(b) {
			return ConsoleUtils.color(logUtils.value);
		}
        //noinspection ReturnOfNull
        return null;
    }

    public static void log(LogUtils level) {
        if(debugger) System.out.println(LogUtils.setUp(level, true));
    }

    public static void log(LogUtils level, String message) {
        if(debugger) {
            System.out.println(LogUtils.setUp(level) + message);
            LogUtils.log(LogUtils.NORMAL);
        }
    }

}