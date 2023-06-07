package com.kuliah.latihanspringboot.Halaman1;

import com.kuliah.latihanspringboot.model.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
// RequestMapping(value = "/api")
@Slf4j
public class TestController {
    @GetMapping(value = "/dashboard")
    public String openDashboardPage(Model model, HttpServletResponse httpServletResponse, HttpServletRequest request) {
        log.info("Selamat anda berhasil masuk ke halaman dashboard!");
        return "dashboard";
    }

    @GetMapping(value = "/register")
    public String openRegisterPage(Model model, HttpServletResponse httpServletResponse, HttpServletRequest request) {
        log.info("Selamat Anda Berhasil masuk ke halaman register!");
        return "register";
    }

    @GetMapping(value = "/login")
    public String openLoginPage(Model model, HttpServletResponse httpServletResponse, HttpServletRequest request) {
        log.info("Selamat Anda berhasil masuk ke halaman login");
        model.addAttribute("LoginInput", new AppUser());
        return "login";
    }
    @PostMapping(value = "/login")
    public String submitLogin(@ModelAttribute("LoginInput") AppUser appUser, Model model, HttpServletResponse httpServletResponse, HttpServletRequest request) {
        log.info("========================");
        log.info("LOGIN ATTEMPT");
        log.info("========================");
        log.info("username: {}", appUser.getUsername());
        log.info("password: {}", appUser.getPassword());
        log.info("CERITANYA AUTHENTICATION");
        // CONTOH KODINGANNYA ADALAH CEK KE DATABASE BY USERNAME, KALAU ADA CEK KESAMAAN PASSWORD
        // KALAU BENAR AUTHENTICATION BERHASIL
        if (appUser.getPassword().matches("ArumDC")) {
            log.info("user with username {} exists", appUser.getUsername());
            if (!appUser.getPassword().equals("password")) {
                log.info("wrong password for user {}", appUser.getUsername());
                System.out.println("\n");
                log.info("=================");
                log.info("LOGIN FAILED");
                log.info("=================");
                return "redirect:/login";
            } else {
                System.out.println("\n");
                log.info("=================");
                log.info("LOGIN SUCCESS");
                log.info("=================");
                return "redirect:/dashboard";
            }
        } else {
            log.info("user with username {} does not exist", appUser.getUsername());
            System.out.println("\n");
            log.info("=================");
            log.info("LOGIN FAILED");
            log.info("=================");
            return "redirect:/register";
        }
    }
}
