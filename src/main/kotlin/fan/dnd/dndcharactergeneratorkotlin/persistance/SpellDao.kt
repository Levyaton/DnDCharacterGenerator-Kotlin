package fan.dnd.dndcharactergeneratorkotlin.persistance

import fan.dnd.dndcharactergeneratorkotlin.domain.ClassName
import jakarta.persistence.*


@Entity
class SpellDao(
    val name: String,
    val page: String? = null,
    val range: String? = null,
    val components: String? = null,
    val ritual: String? = null,
    val duration: String? = null,
    val concentration: String? = null,
    val castingTime: String? = null,
    val level: String? = null,
    val higherLevel: String? = null,
    val school: String? = null,
    @ElementCollection(targetClass = ClassName::class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "class")
    @Column(name = "className")
    val clazz: Set<ClassName>,
    val oaths: String? = null,
    val material: String? = null,
    val patrons: String? = null,
    val circles: String? = null,
    val domains: String? = null,
    val archetype: String? = null,
    @Column(columnDefinition = "TEXT")
    val desc: String,
    val spellId: Int,

    @ManyToMany(mappedBy = "spells", fetch = FetchType.EAGER)
    val players: Set<PlayerDao> = emptySet(),

    @ManyToMany(mappedBy = "spells", fetch = FetchType.EAGER)
    val races: Set<RaceDao> = emptySet(),

): IdAncestor()
