package com.furnycrew.furnidream.store.controller;

import com.furnycrew.furnidream.store.model.dto.StoreDto;
import com.furnycrew.furnidream.store.model.dto.StoreRegistDto;
import com.furnycrew.furnidream.store.model.dto.StoreUpdateDto;
import com.furnycrew.furnidream.store.model.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    // 한 상점의 모든 정보 조회
    @GetMapping("/list")
    public void list(Model model) {
        log.info("GET /store/list");
        StoreDto store = storeService.findAll();
        log.debug("store : {}", store);
        model.addAttribute("store", store);
    }

    // /store/regist 페이지 불러오기 요청
    @GetMapping("/regist")
    public void regist(Model model){
        log.info("GET /store/regist");
        StoreDto store = storeService.findAll();
        model.addAttribute("store", store);
    }

    // 상점 등록 폼 제출
    @PostMapping("/regist")
    public String regist(@ModelAttribute StoreRegistDto storeRegistDto, RedirectAttributes redirectAttributes) {
        log.info("POST /store/regist");
        log.debug("storeRegistDto = {}", storeRegistDto);
        StoreDto storeDto = storeRegistDto.toStoreDto();
        int result = storeService.insertStore(storeDto);
        redirectAttributes.addFlashAttribute("message", "상점을 성공적으로 등록했습니다.👏👏👏");
        log.debug("result = {}", result);
        return "redirect:/store/list";
    }

    // 상품 수정
    @PostMapping("/modify")
    public String modify(@ModelAttribute StoreUpdateDto storeUpdateDto, RedirectAttributes redirectAttributes) {
        log.info("POST /store/modify");
        StoreDto storeDto = storeUpdateDto.toStoreDto();
        int result = storeService.insertStore(storeDto);
        redirectAttributes.addFlashAttribute("message", "상점을 성공적으로 수정했습니다✨✨✨");
        log.debug("result = {}", result);
        return "redirect:/store/list";
    }
}
