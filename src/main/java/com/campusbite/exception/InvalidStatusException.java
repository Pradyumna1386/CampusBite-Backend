package com.campusbite.exception;
public class InvalidStatusException extends RuntimeException { public InvalidStatusException(){super("Invalid status. Use PENDING, PREPARING, READY or COMPLETED.");} }
