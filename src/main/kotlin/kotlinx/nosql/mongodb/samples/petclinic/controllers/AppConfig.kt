package kotlinx.nosql.mongodb.samples.petclinic.controllers

import org.springframework.context.annotation.Configuration
import kotlinx.nosql.mongodb.MongoDB
import kotlinx.nosql.mongodb.samples.petclinic.data.*
import org.springframework.context.annotation.Bean
import com.mongodb.MongoClientURI
import kotlinx.nosql.CreateDrop

Configuration open class AppConfig {
    Bean open fun getMongoDB(): MongoDB {
        val mongoURI = MongoClientURI(System.getenv("MONGOHQ_URL"))
        val mongoDb = MongoDB(mongoURI, schemas = array(Owners, Pets, PetTypes, Vets, Visits), initialization = CreateDrop())
        return mongoDb
    }
}