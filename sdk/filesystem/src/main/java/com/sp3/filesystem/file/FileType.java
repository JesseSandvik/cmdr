package com.sp3.filesystem.file;

public enum FileType {

    INI {
        @Override
        public IFileHandler getFileHandler() {
            return new DefaultFileHandler();
        }
    },

    JSON {
        @Override
        public IFileHandler getFileHandler() {
            return new DefaultFileHandler();
        }
    },

    LOG {
        @Override
        public IFileHandler getFileHandler() {
            return new DefaultFileHandler();
        }
    },

    PROPERTIES {
        @Override
        public IFileHandler getFileHandler() {
            return new DefaultFileHandler();
        }
    },

    TXT {
        @Override
        public IFileHandler getFileHandler() {
            return new DefaultFileHandler();
        }
    };

    public abstract IFileHandler getFileHandler();
}
