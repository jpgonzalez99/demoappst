package com.paradigma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.paradigma.entities.FlightStatistics;

@Component
public class StatisticsDAODefault implements StatisticsDAO{


	@Autowired
	JdbcTemplate jdbcTemplate;

	 
	 public List<FlightStatistics> getFlightstatistics(String origin, String destination){
		 return jdbcTemplate.query("select * from allflights where origin = ? and dest = ?", 
				            new Object[]{origin,destination},
				            new AllFlightsRowMapper());
	 }


	@Override
	public List<FlightStatistics> getFlightstatisticsForCarrier(String origin, String destination, String carrier) {
		 return jdbcTemplate.query("select * from allflights where origin = ? and dest = ? and uniquecarrier= ?", 
		            new Object[]{origin,destination,carrier},
		            new AllFlightsRowMapper());
	}
	

	
	private class AllFlightsRowMapper implements RowMapper<FlightStatistics>{

		@Override
		public FlightStatistics mapRow(ResultSet rs, int rownum) throws SQLException {
			return FlightStatistics.builder().year(rs.getInt("year"))
                    .uniquecarrier(rs.getString("uniquecarrier"))
                    .flightnum(rs.getInt("flightnum"))
                    .airtime(rs.getInt("airtime"))
                    .arrdelay(rs.getInt("arrdelay"))
                    .depdelay(rs.getInt("depdelay"))
                    .origin(rs.getString("origin"))
                    .dest(rs.getString("dest"))
                    .distance(rs.getInt("distance"))
                    .cancelled(rs.getString("cancelled"))
                    .cancellationcode(rs.getString("cancellationcode"))
                    .diverted(rs.getString("diverted"))
                    .carrierdelay(rs.getString("carrierdelay"))
                    .weatherdelay(rs.getString("weatherdelay"))
                    .nasdelay(rs.getString("nasdelay"))
                    .securitydelay(rs.getString("securitydelay"))
                    .lateaircraftdelay(rs.getString("lateaircraftdelay"))
                    .build();
		}
		
	}
}
