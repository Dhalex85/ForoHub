package com.alura.ForoHub.domain.topic;

public record DatosTopic(
        Long id,
        String autor,
        String titulo,
        String mensaje,
        Curso curso,
        String fechaCreacion,
        Integer CantidadRespuestas,
        String estado
) {

    public DatosTopic(Topico topico) {
        this(topico.getId(), topico.getAutor(), topico.getTitulo(),
                topico.getMensaje(), topico.getCurso(), topico.getFechaCreacion().toString(),
                topico.getRespuestas(), topico.getStatus()
        );
    }
}