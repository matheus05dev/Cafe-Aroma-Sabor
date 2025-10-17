package com.projeto.CafeAromaESabor.Controller;

import com.projeto.CafeAromaESabor.Model.User;
import com.projeto.CafeAromaESabor.Repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Getter
@Setter
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/usuarios/novo")
    public String showCreateUserForm(Model model) {
        model.addAttribute("usuario", new User());
        return "criar-usuario";
    }

    @PostMapping("/usuarios/novo")
    public String CriarUser(User usuario, RedirectAttributes redirectAttributes){
        userRepository.save(usuario);
        redirectAttributes.addFlashAttribute("message", "Usuário criado com sucesso!");
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", userRepository.findAll());
        return "usuarios-lista";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String showEditUserForm(Model model){
        return "editar-usuario";
    }

    @PatchMapping("/usuarios/editar/{id}")
    public  String editarUsuario(User usuario, RedirectAttributes redirectAttributes, @PathVariable Long id){
        userRepository.save(usuario);
        redirectAttributes.addFlashAttribute("message", "Usuário editado com sucesso!");
        return "redirect:/usuarios";
    }
}