package com.csec.CatholicTableMatching.controller;

import com.csec.CatholicTableMatching.domain.MatchForm;
import com.csec.CatholicTableMatching.security.domain.User;
import com.csec.CatholicTableMatching.security.repository.UserRepository;
import com.csec.CatholicTableMatching.service.MatchingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MatchingController {

    private MatchingService matchingService;

    private UserRepository userRepository;

    private MatchForm matchForm;

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/match")
    @PreAuthorize("isAuthenticated()")
    public String MatchStart(@ModelAttribute User user , Model model){
        model.addAttribute("matchForm", new MatchForm());
        return "match_form_nes";
    } // 매치 폼 화면이동

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/match")
    public String findMatches(@ModelAttribute("matchForm") MatchForm matchForm) {
        Long userId = matchForm.getUser().getId(); // 가정: getUser()가 사용자 ID를 반환한다.
        return "redirect:/match/" + userId;
    } // 매치 넣으면 매치현황판 으로 이동할수 있게

    @PreAuthorize("isAuthenticated()") // todo 사용자 id와 인증한 주체의 id가 동일한지도 검사 필요
    @RequestMapping("/match/{userId}")
    public String MatchStatus(@PathVariable("userId") Long userId, Model model){
        User user = userRepository.findUserById(userId).orElseThrow(
                () -> new RuntimeException("No customer found with ID " + userId));
        model.addAttribute("customer", user);
        return "match_status";

    } // 매치 현황판



}