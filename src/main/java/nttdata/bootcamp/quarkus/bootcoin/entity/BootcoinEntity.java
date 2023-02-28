package nttdata.bootcamp.quarkus.bootcoin.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity(collection="bootcoin")
public class BootcoinEntity extends ReactivePanacheMongoEntity {

    private ObjectId id;
    private String dniClient;
    private String nroPhone;
    private String email;
    private double amount;
}
