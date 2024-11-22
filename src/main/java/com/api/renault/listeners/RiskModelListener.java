package com.api.renault.listeners;

import com.api.renault.models.ChangeLogModel;
import com.api.renault.models.RiskModel;
import com.api.renault.repository.ChangeLogRepository;
import com.api.renault.repository.RiskRepository;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class RiskModelListener {

    @Autowired
    @Lazy // Resolve dependência circular
    private ChangeLogRepository changeLogRepository;

    @Autowired
    @Lazy
    private RiskRepository riskRepository;

    @PreUpdate
    public void preUpdate(RiskModel riskModel) {
        // Carrega o estado antigo do banco
        RiskModel oldRiskModel = riskRepository.findById(riskModel.getIdRisk())
                .orElseThrow(() -> new IllegalStateException("Registro não encontrado para auditoria."));

        // Compara cada campo da entidade usando reflexão
        Field[] fields = RiskModel.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object oldValue = field.get(oldRiskModel);
                Object newValue = field.get(riskModel);
                if (!Objects.equals(oldValue, newValue)) {
                    saveChangeLog(riskModel.getIdRisk(), field.getName(), oldValue, newValue);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Erro ao acessar o campo: " + field.getName(), e);
            }
        }
    }

    private void saveChangeLog(Integer entityId, String fieldName, Object oldValue, Object newValue) {
        ChangeLogModel log = new ChangeLogModel();
        log.setEntityId(entityId);
        log.setEntityName("RiskModel");
        log.setFieldName(fieldName);
        log.setOldValue(oldValue != null ? oldValue.toString() : null);
        log.setNewValue(newValue != null ? newValue.toString() : null);
        log.setTimestamp(LocalDateTime.now());
        changeLogRepository.save(log);
    }
}
