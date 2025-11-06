package com.projeto.CafeAromaESabor.Controller;

import com.projeto.CafeAromaESabor.Model.User;
import com.projeto.CafeAromaESabor.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/usuarios/novo")
    public String showCreateUserForm(Model model) {
        model.addAttribute("usuario", new User());
        return "criar-usuario";
    }

    @PostMapping("/usuarios/novo")
    public String CriarUser(User usuario, RedirectAttributes redirectAttributes){
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        if (usuario.getRoles() == null || usuario.getRoles().isEmpty()) {
            usuario.setRoles(Collections.singletonList("ROLE_USER"));
        }
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
    public String showEditUserForm(@PathVariable Long id, Model model){
        User usuario = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de usuário inválido:" + id));
        model.addAttribute("usuario", usuario);
        return "editar-usuario";
    }

    @PostMapping("/usuarios/editar/{id}")
    public String editarUsuario(@PathVariable Long id, User usuario, RedirectAttributes redirectAttributes){
        User userExistente = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de usuário inválido:" + id));

        userExistente.setUsername(usuario.getUsername());
        userExistente.setNome(usuario.getNome());
        userExistente.setEmail(usuario.getEmail());
        userExistente.setCpf(usuario.getCpf());
        userExistente.setRoles(usuario.getRoles());

        if (usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {
            userExistente.setSenha(passwordEncoder.encode(usuario.getSenha()));
        }

        userRepository.save(userExistente);
        redirectAttributes.addFlashAttribute("message", "Usuário editado com sucesso!");
        return "redirect:/usuarios";
    }

    @DeleteMapping("/usuarios/apagar/{id}")
    public String deletarUser(@PathVariable Long id, RedirectAttributes redirectAttributes){
        userRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Usuário deletado com sucesso!");
        return "redirect:/usuarios";
    }
}
