package com.google.mediapipe.examples.hands

/**
 * Created by: androdev
 * Date: 01-12-2022
 * Time: 11:32 AM
 * Email: Khudoyshukur.Juraev.001@mail.ru
 */

data class HandState(
    val thumbFingerState: FingerState,
    val indexFingerState: FingerState,
    val middleFingerState: FingerState,
    val ringFingerState: FingerState,
    val pinkyFingerState: FingerState,
) {

    fun getFingerStateSpeeches() = buildList<String> {
        add(getHandStateSpeech(thumbFingerState, "Thumb"))
        add(getHandStateSpeech(indexFingerState, "Index"))
        add(getHandStateSpeech(middleFingerState, "Middle"))
        add(getHandStateSpeech(ringFingerState, "Ring"))
        add(getHandStateSpeech(pinkyFingerState, "Pinky"))
    }

    fun getDifferenceSpeeches(other: HandState?) = buildList<String> {
        if (other == null) {
            return this
        }

        if (thumbFingerState != other.thumbFingerState) {
            add(getHandStateSpeech(thumbFingerState, "Thumb"))
        }

        if (indexFingerState != other.indexFingerState) {
            add(getHandStateSpeech(indexFingerState, "Index"))
        }

        if (middleFingerState != other.middleFingerState) {
            add(getHandStateSpeech(middleFingerState, "Middle"))
        }

        if (ringFingerState != other.ringFingerState) {
            add(getHandStateSpeech(ringFingerState, "Ring"))
        }

        if (pinkyFingerState != other.pinkyFingerState) {
            add(getHandStateSpeech(pinkyFingerState, "Pinky"))
        }
    }

    private fun getHandStateSpeech(fingerState: FingerState, title: String) = when (fingerState) {
        FingerState.OPEN -> ("$title finger is open")
        FingerState.CLOSED -> ("$title finger is closed")
    }

    companion object {
        fun from(
            isThumbClosed: Boolean,
            isIndexClosed: Boolean,
            isMiddleClosed: Boolean,
            isRingClosed: Boolean,
            isPinkyClosed: Boolean,
        ): HandState {
            return HandState(
                thumbFingerState = if (isThumbClosed) FingerState.CLOSED else FingerState.OPEN,
                indexFingerState = if (isIndexClosed) FingerState.CLOSED else FingerState.OPEN,
                middleFingerState = if (isMiddleClosed) FingerState.CLOSED else FingerState.OPEN,
                ringFingerState = if (isRingClosed) FingerState.CLOSED else FingerState.OPEN,
                pinkyFingerState = if (isPinkyClosed) FingerState.CLOSED else FingerState.OPEN,
            )
        }
    }
}

enum class FingerState {
    OPEN, CLOSED;
}