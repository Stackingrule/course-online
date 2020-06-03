package com.course.server.util;

import com.course.server.exception.ValidatorException;
import org.springframework.util.StringUtils;

/**
 * <h1>校验工具类</h1>
 */
public class ValidatorUtil {

    /**
     * <h2>空校验</h2>
     * @param str {@link String}
     * @param fileName {@link String}
     */
    public static void require(String str, String fileName) {
        if (StringUtils.isEmpty(str)) {
            throw new ValidatorException(fileName + "不能为空");
        }
    }

    /**
     * <h2>长度校验</h2>
     * @param str {@link String}
     * @param fileName {@link String}
     * @param min {@link Integer}
     * @param max {@link Integer}
     */
    public static void length(String str, String fileName, int min, int max) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        int length = 0;
        if (!StringUtils.isEmpty(str)) {
            length = str.length();
        }
        if (length < min || length > max) {
            throw new ValidatorException(fileName + "长度" + min + "~" + max + "位");
        }

    }
}
