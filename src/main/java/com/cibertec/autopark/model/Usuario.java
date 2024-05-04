package com.cibertec.autopark.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String name;

    private String lastname;

    @ManyToOne
    @JoinColumn(name = "tipo_documento")
    private TipoDocumento tipoDocumento;

    @Column(name = "nro_documento", nullable = false, unique = true)
    private String nroDocumento;

    private String correo;

    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.getRole()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
