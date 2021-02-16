import java.time.LocalDateTime

class NotesService {

    private val notes = mutableListOf<Note>()
    private val notesWithComments = mutableMapOf<Note, MutableList<Comment>>()
    private val deleteNotesWithComments = mutableMapOf<Note, MutableList<Comment>>()
    private val deleteNotes = mutableListOf<Note>()
    private val date = LocalDateTime.now().second

    fun add(title: String, text: String): Int { /* privacy fields are not included*/
        val noteId = if (notes.isEmpty()) 0 else notes.last().id + 1
        val newNote = Note(id = noteId, title = title, text = text, date = date)
        notes.add(newNote)
        notesWithComments[newNote] = mutableListOf()
        return noteId
    }

    fun createComment(noteId: Int, replyID: Int? = null, message: String) {
        var noteExists = false
        notesWithComments.forEach {
            if (it.key.id == noteId) {
                val commentsList = notesWithComments[it.key]
                val comId = if (commentsList?.isEmpty() == true) 0 else (commentsList?.last()?.id ?: 0) + 1
                commentsList?.add(
                    Comment(
                        id = comId, postId = noteId, replyToUser = replyID,
                        text = message, date = date
                    )
                )
                noteExists = true
            }
        }
        if (!noteExists) throw NoteNotFoundException("Note is not found!")
    }

    fun delete(noteId: Int): Int {
        var noteExists = false
        notes.forEach {
            if (it.id == noteId) {
                notes.remove(it)
                deleteNotes.add(it)
                noteExists = true
            }
        }
        if (!noteExists) throw NoteNotFoundException("Note is not found!")
        return 1
    }

    fun deleteComment(comId: Int): Int {
        var commentExists = false
        notesWithComments.forEach { biggerIt ->
            val listWithComments = biggerIt.value
            listWithComments.forEach {
                if (it.id == comId) {
                    listWithComments.remove(it)
                    deleteNotesWithComments[biggerIt.key] = mutableListOf()
                    deleteNotesWithComments[biggerIt.key]?.add(it)
                    commentExists = true
                }
            }
        }
        if (!commentExists) throw CommentNotFoundException("Comment is not found!")
        return 1
    }

    fun edit(noteId: Int, title: String, text: String): Int {
        var noteExists = false
        notes.forEach{
            if (it.id == noteId) {
                notes.remove(it)
                notes.add(it.copy(title = title, text = text))
                noteExists = true
            }
        }
        if (!noteExists) throw NoteNotFoundException("Note is not found!")
        return 1
    }
}