package com.api.renault.service;

import com.api.renault.dto.NotificationDTO;
import com.api.renault.models.NotificationModel;
import com.api.renault.models.RiskModel;
import com.api.renault.repository.NotificationRepository;
import com.api.renault.repository.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private RiskRepository riskRepository;


    private NotificationDTO toDTO(NotificationModel model) {

        NotificationDTO dto = new NotificationDTO();
        dto.setIdNotification(model.getIdNotification());
        dto.setTitleNotification(model.getTitleNotification());
        dto.setDescriptionNotification(model.getDescriptionNotification());
        dto.setIdRisk(model.getRiskModel().getIdRisk());

        return dto;
    }


    private NotificationModel toModel(NotificationDTO dto) {

        NotificationModel model = new NotificationModel();
        model.setIdNotification(dto.getIdNotification());
        model.setTitleNotification(dto.getTitleNotification());
        model.setDescriptionNotification(dto.getDescriptionNotification());

        RiskModel riskModel = riskRepository.findById(dto.getIdRisk()).orElse(null);
        model.setRiskModel(riskModel);

        return model;
    }

    public NotificationDTO create(NotificationDTO dto) {
        NotificationModel model = toModel(dto);
        NotificationModel savedModel = notificationRepository.save(model);
        return toDTO(savedModel);
    }

    public void delete(Integer id) {
        notificationRepository.deleteById(id);
    }

    public Optional<NotificationDTO> get(Integer id) {
        Optional<NotificationModel> model = notificationRepository.findById(id);
        return model.map(this::toDTO);
    }

    public List<NotificationDTO> getAll() {
        List<NotificationModel> models = notificationRepository.findAll();
        return models.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
