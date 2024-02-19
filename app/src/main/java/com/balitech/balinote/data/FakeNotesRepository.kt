package com.balitech.balinote.data

import com.balitech.balinote.domain.models.common.BackgroundColor
import com.balitech.balinote.domain.models.note.Note

object FakeNotesRepository {

    private const val body = "Build a custom color scheme to map dynamic color, use as fallback colors, or implement a branded theme. The color system automatically handles critical adjustments that provide accessible color contrast."

    fun getNoteById(id: String): Note? = getNotes().find { it.id == id }

    fun getNotes(): List<Note> = listOf(
        Note(id = "Note-1", title = "Test Note One", body = body, background = BackgroundColor.None),
        Note(id = "Note-2", title = "Test Note Two", body = body.plus(body), background = BackgroundColor.Purple),
        Note(id = "Note-3", title = "Test Note Three", body = body, background = BackgroundColor.Pink),
        Note(id = "Note-4", title = "Test Note Four", body = body, background = BackgroundColor.Blue),
        Note(id = "Note-5", title = "Test Note Five", body = body.plus(body), background = BackgroundColor.Gold),
        Note(id = "Note-6", title = "Test Note Six", body = body, background = BackgroundColor.Green),
        Note(id = "Note-7", title = "Test Note Seven", body = body, background = BackgroundColor.Yellow),
        Note(id = "Note-8", title = "Test Note Eight", body = body, background = BackgroundColor.Cyan),
        Note(id = "Note-9", title = "Test Note Nine", body = body.plus(body), background = BackgroundColor.Grey),
        Note(id = "Note-10", title = "Test Note Ten", body = body, background = BackgroundColor.Evergreen),
        Note(id = "Note-11", title = "Test Note Eleven", body = body, background = BackgroundColor.Silver)
    )

}