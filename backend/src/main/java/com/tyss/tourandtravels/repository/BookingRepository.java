package com.tyss.tourandtravels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.tourandtravels.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
