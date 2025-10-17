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
    public String showEditUserForm(@PathVariable Long id, Model model){
        User usuario = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de usuário inválido:" + id));
        model.addAttribute("usuario", usuario);
        return "editar-usuario";
    }

    @PostMapping("/usuarios/editar/{id}")
    public String editarUsuario(@PathVariable Long id, User usuario, RedirectAttributes redirectAttributes){
        User UserExistente = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de usuário inválido:" + id));

        UserExistente.setUsername(usuario.getUsername());
        UserExistente.setNome(usuario.getNome());
        UserExistente.setEmail(usuario.getEmail());
        UserExistente.setCpf(usuario.getCpf());

        // Só atualiza a senha se uma nova for fornecida
        if (usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {
            // Lembre-se de criptografar a nova senha aqui
            UserExistente.setSenha(usuario.getSenha());
        }

        userRepository.save(UserExistente);
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