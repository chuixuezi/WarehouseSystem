package com.xt.sys.common;

import com.xt.sys.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiverUser {
    private User User;

    private List<String> roles;

    private List<String> permissions;

}
