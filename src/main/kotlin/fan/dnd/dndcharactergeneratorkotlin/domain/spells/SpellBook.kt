package fan.dnd.dndcharactergeneratorkotlin.domain.spells

import fan.dnd.dndcharactergeneratorkotlin.domain.spells.bard.*
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.cleric.*
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.druid.*
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.palladin.*
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.ranger.*
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.wizard.*
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.ritual.*
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.sorcerer.*
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.warlock.*

class SpellBook {
    companion object {
        fun findBardCantrip(id: Int) = BardSpellCantrip.entries.find { it.id == id }
        fun findBard1stLevelSpell(id: Int) = BardSpell1level.entries.find { it.id == id }
        fun findBard2ndLevelSpell(id: Int) = BardSpell2level.entries.find { it.id == id }
        fun findBard3rdLevelSpell(id: Int) = BardSpell3level.entries.find { it.id == id }
        fun findBard4thLevelSpell(id: Int) = BardSpell4level.entries.find { it.id == id }
        fun findBard5thLevelSpell(id: Int) = BardSpell5level.entries.find { it.id == id }
        fun findBard6thLevelSpell(id: Int) = BardSpell6level.entries.find { it.id == id }
        fun findBard7thLevelSpell(id: Int) = BardSpell7level.entries.find { it.id == id }
        fun findBard8thLevelSpell(id: Int) = BardSpell8level.entries.find { it.id == id }
        fun findBard9thLevelSpell(id: Int) = BardSpell9level.entries.find { it.id == id }

        fun findClericCantrip(id: Int) = ClericSpellCantrip.entries.find { it.id == id }
        fun findCleric1stLevelSpell(id: Int) = ClericSpell1level.entries.find { it.id == id }
        fun findCleric2ndLevelSpell(id: Int) = ClericSpell2level.entries.find { it.id == id }
        fun findCleric3rdLevelSpell(id: Int) = ClericSpell3level.entries.find { it.id == id }
        fun findCleric4thLevelSpell(id: Int) = ClericSpell4level.entries.find { it.id == id }
        fun findCleric5thLevelSpell(id: Int) = ClericSpell5level.entries.find { it.id == id }
        fun findCleric6thLevelSpell(id: Int) = ClericSpell6level.entries.find { it.id == id }
        fun findCleric7thLevelSpell(id: Int) = ClericSpell7level.entries.find { it.id == id }
        fun findCleric8thLevelSpell(id: Int) = ClericSpell8level.entries.find { it.id == id }
        fun findCleric9thLevelSpell(id: Int) = ClericSpell9level.entries.find { it.id == id }

        fun findDruidCantrip(id: Int) = DruidSpellCantrip.entries.find { it.id == id }
        fun findDruid1stLevelSpell(id: Int) = DruidSpell1level.entries.find { it.id == id }
        fun findDruid2ndLevelSpell(id: Int) = DruidSpell2level.entries.find { it.id == id }
        fun findDruid3rdLevelSpell(id: Int) = DruidSpell3level.entries.find { it.id == id }
        fun findDruid4thLevelSpell(id: Int) = DruidSpell4level.entries.find { it.id == id }
        fun findDruid5thLevelSpell(id: Int) = DruidSpell5level.entries.find { it.id == id }
        fun findDruid6thLevelSpell(id: Int) = DruidSpell6level.entries.find { it.id == id }
        fun findDruid7thLevelSpell(id: Int) = DruidSpell7level.entries.find { it.id == id }
        fun findDruid8thLevelSpell(id: Int) = DruidSpell8level.entries.find { it.id == id }
        fun findDruid9thLevelSpell(id: Int) = DruidSpell9level.entries.find { it.id == id }

        fun findPaladin1stLevelSpell(id: Int) = PaladinSpell1level.entries.find { it.id == id }
        fun findPaladin2ndLevelSpell(id: Int) = PaladinSpell2level.entries.find { it.id == id }
        fun findPaladin3rdLevelSpell(id: Int) = PaladinSpell3level.entries.find { it.id == id }
        fun findPaladin4thLevelSpell(id: Int) = PaladinSpell4level.entries.find { it.id == id }
        fun findPaladin5thLevelSpell(id: Int) = PaladinSpell5level.entries.find { it.id == id }

        fun findRanger1stLevelSpell(id: Int) = RangerSpell1level.entries.find { it.id == id }
        fun findRanger2ndLevelSpell(id: Int) = RangerSpell2level.entries.find { it.id == id }
        fun findRanger3rdLevelSpell(id: Int) = RangerSpell3level.entries.find { it.id == id }
        fun findRanger4thLevelSpell(id: Int) = RangerSpell4level.entries.find { it.id == id }
        fun findRanger5thLevelSpell(id: Int) = RangerSpell5level.entries.find { it.id == id }

        fun findWizardCantrip(id: Int) = WizardSpellCantrip.entries.find { it.id == id }
        fun findWizard1stLevelSpell(id: Int) = WizardSpell1level.entries.find { it.id == id }
        fun findWizard2ndLevelSpell(id: Int) = WizardSpell2level.entries.find { it.id == id }
        fun findWizard3rdLevelSpell(id: Int) = WizardSpell3level.entries.find { it.id == id }
        fun findWizard4thLevelSpell(id: Int) = WizardSpell4level.entries.find { it.id == id }
        fun findWizard5thLevelSpell(id: Int) = WizardSpell5level.entries.find { it.id == id }
        fun findWizard6thLevelSpell(id: Int) = WizardSpell6level.entries.find { it.id == id }
        fun findWizard7thLevelSpell(id: Int) = WizardSpell7level.entries.find { it.id == id }
        fun findWizard8thLevelSpell(id: Int) = WizardSpell8level.entries.find { it.id == id }
        fun findWizard9thLevelSpell(id: Int) = WizardSpell9level.entries.find { it.id == id }

        fun findRitual1stLevelSpell(id: Int) = RitualCasterSpell1level.entries.find { it.id == id }
        fun findRitual2ndLevelSpell(id: Int) = RitualCasterSpell2level.entries.find { it.id == id }
        fun findRitual3rdLevelSpell(id: Int) = RitualCasterSpell3level.entries.find { it.id == id }
        fun findRitual4thLevelSpell(id: Int) = RitualCasterSpell4level.entries.find { it.id == id }
        fun findRitual5thLevelSpell(id: Int) = RitualCasterSpell5level.entries.find { it.id == id }
        fun findRitual6thLevelSpell(id: Int) = RitualCasterSpell6level.entries.find { it.id == id }

        fun findSorcererCantrip(id: Int) = SorcererSpellCantrip.entries.find { it.id == id }
        fun findSorcerer1stLevelSpell(id: Int) = SorcererSpell1level.entries.find { it.id == id }
        fun findSorcerer2ndLevelSpell(id: Int) = SorcererSpell2level.entries.find { it.id == id }
        fun findSorcerer3rdLevelSpell(id: Int) = SorcererSpell3level.entries.find { it.id == id }
        fun findSorcerer4thLevelSpell(id: Int) = SorcererSpell4level.entries.find { it.id == id }
        fun findSorcerer5thLevelSpell(id: Int) = SorcererSpell5level.entries.find { it.id == id }
        fun findSorcerer6thLevelSpell(id: Int) = SorcererSpell6level.entries.find { it.id == id }
        fun findSorcerer7thLevelSpell(id: Int) = SorcererSpell7level.entries.find { it.id == id }
        fun findSorcerer8thLevelSpell(id: Int) = SorcererSpell8level.entries.find { it.id == id }
        fun findSorcerer9thLevelSpell(id: Int) = SorcererSpell9level.entries.find { it.id == id }

        fun findWarlockCantrip(id: Int) = WarlockSpellCantrip.entries.find { it.id == id }
        fun findWarlock1stLevelSpell(id: Int) = WarlockSpell1level.entries.find { it.id == id }
        fun findWarlock2ndLevelSpell(id: Int) = WarlockSpell2level.entries.find { it.id == id }
        fun findWarlock3rdLevelSpell(id: Int) = WarlockSpell3level.entries.find { it.id == id }
        fun findWarlock4thLevelSpell(id: Int) = WarlockSpell4level.entries.find { it.id == id }
        fun findWarlock5thLevelSpell(id: Int) = WarlockSpell5level.entries.find { it.id == id }
        fun findWarlock6thLevelSpell(id: Int) = WarlockSpell6level.entries.find { it.id == id }
        fun findWarlock7thLevelSpell(id: Int) = WarlockSpell7level.entries.find { it.id == id }
        fun findWarlock8thLevelSpell(id: Int) = WarlockSpell8level.entries.find { it.id == id }
        fun findWarlock9thLevelSpell(id: Int) = WarlockSpell9level.entries.find { it.id == id }


    }


}