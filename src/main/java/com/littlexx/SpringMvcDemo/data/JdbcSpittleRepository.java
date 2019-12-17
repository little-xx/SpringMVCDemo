package com.littlexx.SpringMvcDemo.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.littlexx.SpringMvcDemo.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class JdbcSpittleRepository implements SpittleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Spittle> findRecentSpittles() {
        return jdbcTemplate.query(
                "select id, message, created_at, latitude, longitude" +
                        " from Spittle" +
                        " order by created_at desc limit 20",
                new SpittleRowMapper());
    }

    public List<Spittle> findSpittles(long max, int count) {
        return jdbcTemplate.query("select * from spittle limit ? ", new SpittleRowMapper(),max);
    }

    public Spittle findOne(long id) {
        return jdbcTemplate.queryForObject(
                "select id, message, created_at, latitude, longitude" +
                        " from Spittle" +
                        " where id = ?",
                new SpittleRowMapper(), id);
    }

    public void save(Spittle spittle) {
        jdbcTemplate.update(
                "insert into Spittle (message, created_at, latitude, longitude)" +
                        " values (?, ?, ?, ?)",
                spittle.getMessage(),
                spittle.getDate(),
                spittle.getLatitude(),
                spittle.getLongitude());
    }

    private static class SpittleRowMapper implements RowMapper<Spittle> {
        public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spittle(
                    rs.getLong("id"),
                    rs.getString("message"),
                    rs.getDate("created_at"),
                    rs.getDouble("longitude"),
                    rs.getDouble("latitude"));
        }
    }

}
