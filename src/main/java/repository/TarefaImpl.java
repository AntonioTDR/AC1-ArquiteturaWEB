package repository;

import model.Tarefa;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@Repository
public class TarefaImpl implements TarefaRepository {

    private final JdbcTemplate jdbcTemplate;

    public TarefaImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tarefa> findAll() {
        return jdbcTemplate.query("SELECT * FROM Tarefa", (resultSet, rowNum) -> {
            System.out.println("Número da linha: " + rowNum);
            return new Task(
                resultSet.getLong("id"),
                resultSet.getString("Titulo"),
                resultSet.getString("Descrição")
            );
        });
    }

    @Override
    public Tarefa findById(Long id) {
        String query = "SELECT * FROM tarefa WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, rowNum) ->
            new Task(
                resultSet.getLong("id"),
                resultSet.getString("Titulo"),
                resultSet.getString("Descrição")
            )
        );
    }

    @Override
    public Tarefa save(Tarefa tarefa) {
        if (tarefa.getId() == null) {
            String insertQuery = "INSERT INTO public.task (Titulo, Descrição) VALUES (?, ?)";
            jdbcTemplate.update(insertQuery, tarefa.gettitulo(), tarefa.getdescricao());
        } else {
            String updateQuery = "UPDATE public.task SET title = ?, description = ? WHERE id = ?";
            jdbcTemplate.update(updateQuery, tarefa.gettitulo(), tarefa.getdescricao(), tarefa.getId());
        }
        return tarefa;
    }
}
