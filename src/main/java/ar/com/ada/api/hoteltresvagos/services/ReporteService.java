package ar.com.ada.api.hoteltresvagos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.hoteltresvagos.repositories.*;
import ar.com.ada.api.hoteltresvagos.entities.reportes.*;

@Service
public class ReporteService {

    @Autowired
    ReservaRepository reporteRepo;

    public List<ReporteEstado> getReporteReservasPorEstado() {

        return reporteRepo.getReporteReservasPorEstado();
    }

    public List<ReportePorHuesped> getReporteReservasPorHuespedes() {

        return reporteRepo.getReporteReservasPorHuespedes();
    }

}
