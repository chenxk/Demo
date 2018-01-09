
/*
* Copyright 2017 Meorient, Inc. All rights reserved.
*/

package com.demo.test.beans;

import com.demo.test.util.MyApplication;

import java.io.Serializable;


/**
 * Description of Base
 *
 * @author charles.chen
 * @version $Id: BaseDto.java 1340 2017-02-10 01:12:49Z charles.chen $
 * @created on 2017年1月16日
 */
public class BaseDto implements Serializable {

    @Override
    public String toString() {
        return MyApplication.getGson().toJson(this);
    }
}
