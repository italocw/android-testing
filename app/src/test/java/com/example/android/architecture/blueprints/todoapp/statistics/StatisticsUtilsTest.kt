package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat

import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )
        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat( result.completedTasksPercent, `is` (0f))
        assertThat( result.activeTasksPercent,  `is` (100f))
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {

        // Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false)
        )
        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat( result.completedTasksPercent,  `is` (40f))
        assertThat( result.activeTasksPercent,  `is` (60f))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {

        // Create an active tasks (the false makes this active)
        val tasks = listOf<Task>()
        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat( result.completedTasksPercent,  `is` (0f))
        assertThat( result.activeTasksPercent,  `is` (0f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {

        // Create an active tasks (the false makes this active)
        val tasks = null
        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat( result.completedTasksPercent, `is` (0f))
        assertThat( result.activeTasksPercent, `is` (0f))
    }
}