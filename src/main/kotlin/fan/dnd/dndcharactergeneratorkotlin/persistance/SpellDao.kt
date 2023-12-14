package fan.dnd.dndcharactergeneratorkotlin.persistance

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import fan.dnd.dndcharactergeneratorkotlin.configuration.ApplicationContextProvider
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.ClassName
import jakarta.persistence.*


@Entity
class SpellDao @JsonCreator constructor(
    val name: String,
    val page: String? = null,
    val range: String? = null,
    val components: String? = null,
    val ritual: String? = null,
    val duration: String? = null,
    val concentration: String? = null,
    val castingTime: String? = null,
    val level: String? = null,
    @Column(columnDefinition = "TEXT")
    val higherLevel: String? = null,
    val school: String? = null,
    @JsonProperty("clazz")
    @JsonDeserialize(using = ClassNameDeserializer::class) // Use the custom deserializer
    @JsonSerialize(using = ClassNameSerializer::class) // Use the custom serializer
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "spell_class",
        joinColumns = [JoinColumn(name = "spell_id")],
        inverseJoinColumns = [JoinColumn(name = "class_id")]
    )
    val clazz: Set<ClassNameDao>,
    val oaths: String? = null,
    @Column(columnDefinition = "TEXT")
    val material: String? = null,
    val patrons: String? = null,
    val circles: String? = null,
    val domains: String? = null,
    val archetype: String? = null,
    @Column(columnDefinition = "TEXT")
    val desc: String?,
    val spellId: Int,

    ): IdAncestor()

class ClassNameDeserializer : JsonDeserializer<Set<ClassNameDao>>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Set<ClassNameDao> {
        val classRepo = ApplicationContextProvider.getBean(ClassNameRepository::class.java)
        val classNames = p.text.split(",").map { it.trim().uppercase().replace(" ", "_") }

        return classNames.map { classNameString ->
            try {
                classRepo.findByName(ClassName.valueOf(classNameString)) ?:
                throw IllegalArgumentException("Class name $classNameString not found")

            } catch (e: IllegalArgumentException) {
                throw IllegalArgumentException("Class name $classNameString not found")
            }
        }.toSet()
    }
}


class ClassNameSerializer : JsonSerializer<Set<ClassNameDao>>() {
    override fun serialize(
        value: Set<ClassNameDao>,
        gen: JsonGenerator,
        serializers: SerializerProvider
    ) {
        val classNames = value.joinToString(", ") { it.name.name }
        gen.writeString(classNames)
    }
}
