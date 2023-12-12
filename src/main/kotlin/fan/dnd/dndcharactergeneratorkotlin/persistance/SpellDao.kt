package fan.dnd.dndcharactergeneratorkotlin.persistance

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
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
    @JsonDeserialize(using = ClassNameDeserializer::class)
    @ElementCollection(targetClass = ClassName::class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "class")
    @Column(name = "className")
    val clazz: Set<ClassName>,
    val oaths: String? = null,
    @Column(columnDefinition = "TEXT")
    val material: String? = null,
    val patrons: String? = null,
    val circles: String? = null,
    val domains: String? = null,
    val archetype: String? = null,
    @Column(columnDefinition = "TEXT")
    val desc: String,
    val spellId: Int,

    ): IdAncestor()

class ClassNameDeserializer : JsonDeserializer<Set<ClassName>>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Set<ClassName> {
        return p.text.split(",").map { it.trim() }.filter { it.isNotEmpty() }.map { ClassName.valueOf(it.uppercase().replace(" ","_")) }.toSet()
    }
}