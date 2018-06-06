package com.fhj.elventree.utils;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

public class KryoUtils {
    private static final Kryo kryo = new Kryo();
static {
    kryo.register(Method.class);
}
    public static void registerSerialize(List<Class> classes) {
        classes.forEach(clazz -> {
            kryo.register(clazz);
        });
    }

    public static byte[] serializeObject(Object obj) {
        Output outPut = new Output(1024);
        kryo.writeObject(outPut, obj);
        outPut.flush();
        outPut.close();
        return outPut.toBytes();
    }

    public static <T> T unserialize(byte[] bytes, Class<T> clazz) {
        Input input = new Input(bytes);
        input.close();
        return kryo.readObject(input, clazz);
    }
}
