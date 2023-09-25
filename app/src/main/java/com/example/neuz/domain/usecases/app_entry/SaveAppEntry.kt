package com.example.neuz.domain.usecases.app_entry

import com.example.neuz.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager : LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}