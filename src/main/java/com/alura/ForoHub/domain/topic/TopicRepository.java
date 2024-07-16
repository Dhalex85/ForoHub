package com.alura.ForoHub.domain.topic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topico,Long> {

    boolean existsByTitulo(String titulo);

    boolean existsByMensaje(String mensaje);

     Optional<Topico> findById(Long id);
}
