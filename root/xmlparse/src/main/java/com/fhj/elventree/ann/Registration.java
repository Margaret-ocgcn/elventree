package com.fhj.elventree.ann;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Registration  {
    String service();
    String version();
    String method();
    String description();
}
