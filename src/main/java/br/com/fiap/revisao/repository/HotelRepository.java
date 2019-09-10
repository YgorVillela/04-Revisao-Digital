package br.com.fiap.revisao.repository;

import br.com.fiap.revisao.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findByNomeContains(String nome);
}
