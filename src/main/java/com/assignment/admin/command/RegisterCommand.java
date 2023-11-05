package com.assignment.admin.command;

import com.assignment.admin.entity.User;
import com.assignment.admin.entity.UserCredentials;

import lombok.Data;

@Data
public class RegisterCommand {

private User user;
private UserCredentials userCredentials;
}
