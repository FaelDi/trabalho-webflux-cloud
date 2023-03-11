package com.wordpress.faeldi.Eventos.repository;


import com.wordpress.faeldi.Eventos.repository.entity.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventosRepository extends JpaRepository<Eventos, Long> {}
