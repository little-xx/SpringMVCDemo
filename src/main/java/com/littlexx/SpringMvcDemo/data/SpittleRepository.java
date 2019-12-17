package com.littlexx.SpringMvcDemo.data;

import com.littlexx.SpringMvcDemo.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}