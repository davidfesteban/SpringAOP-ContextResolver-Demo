package com.example.demo.repository;

import com.example.demo.annotation.InterceptorMarker;
import org.springframework.stereotype.Repository;

//Just adding another layer to see if we can(not) reach it
@Repository
@InterceptorMarker
public class DemoRepositoryImpl implements DemoRepository{
}
