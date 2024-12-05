package org.example.todolist.repositories;


import org.example.todolist.entities.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que extiende JpaRepository para la gestión de entidades Task en la base de datos.
 * Proporciona métodos CRUD y funcionalidades adicionales para la manipulación de tareas,
 * aprovechando las capacidades de Spring Data JPA.
 */

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
