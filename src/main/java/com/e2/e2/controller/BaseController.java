package com.e2.e2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

public abstract class BaseController<E> {

    protected <T> ResponseEntity<T> ok(T body) { return ResponseEntity.ok(body); }
}
