import java.util.*;

// To execute Kotlin code, please define a top level function named main

fun main(args: Array<String>) {
    val fs = FileSystem()
    fs.mkdir("/some")
    fs.mkdir("/some/path/to/directory")
    fs.mkdir("/some/path")
    fs.mkdir("/some/path/to")
    fs.mkdir("/some/path/to/directory")
    fs.write_file("/some/path/to/directory/file", "foo")
    fs.write_file("/some/path", "bar")
    fs.read_file("/some/path/to/directory/file")
}

class FileSystem {

    private val rootDirs = HashMap<String, Directory>()

    fun mkdir(path: String) {
        mkdir(path, null)
    }

    private fun mkdir(path: String, file: String?) {
        val components = path.split("/")
        var curDir: Directory? = null

        for (i in 1..components.size - 1) {
//            println("iter " + i)
            val dirName = components.get(i)
//            println("dirName: " + dirName)
            if (i == components.size - 1) {
                if (curDir == null) {
                    rootDirs.put(dirName, Directory(file))
                } else {
                    curDir.mkdir(dirName, file)
                }
            } else {
                if (curDir == null) {
                    curDir = rootDirs.get(dirName)
                } else {
                    val nullableCurDir = curDir.getDir(dirName)
                    if (nullableCurDir != null) {
                        curDir = nullableCurDir
                    } else {
                        System.err.println("error")
                        return
                    }
                }
            }
        }

//        rootDirs.entries.forEach {
//            println("/${it.key}/${it.value}")
//        }
    }

    fun write_file(path: String, file: String) {
        mkdir(path, file)
    }

    fun read_file(path: String) {
        val components = path.split("/")
        var curDir: Directory? = null

        for (i in 1..components.size - 1) {
            //println("iter " + i)
            val dirName = components.get(i)
            if (curDir != null) {
                curDir = curDir.getDir(dirName)
            } else {
                curDir = rootDirs.get(dirName)
            }
        }

        if (curDir != null && curDir.file != null) {
            println(curDir.file)
        } else {
            System.err.println("error")
        }
    }
}

class Directory(val file: String? = null) {
    private val children = HashMap<String, Directory>()

    fun mkdir(dirName: String, file: String?) {
        //Trying to add a file but already exists as a directory
        if (file != null && children.containsKey(dirName)) {
            System.err.println("error")
        } else {
          children.put(dirName, Directory(file))
        }
    }

    fun getDir(dirName: String): Directory? {
        return children.get(dirName)
    }

    override fun toString(): String {
        if (file != null) {
            return " $file"
        } else {
            val nullableFirst = children.entries.firstOrNull()
            if (nullableFirst != null)
                return "${nullableFirst.key}/${nullableFirst.value}"
            else
                return ""
        }
    }
}

/*
Your previous Plain Text content is preserved below:

# Implement a file system with the following functions, in your language of choice:
#
# mkdir(path string)
# write_file(path string, content string)
# read_file(path string) string

# Notes:
# Parents must exist before creating something
# Cannot create files where there's a directory and vice-versa
# Consider error cases

# make this pseudo code work in your language of choice:
fs = new FileSystem()
fs.mkdir("/some")
fs.mkdir("/some/path/to/directory") -> error
fs.mkdir("/some/path")
fs.mkdir("/some/path/to")
fs.mkdir("/some/path/to/directory")
fs.write_file("/some/path/to/directory/file", "foo")
fs.write_file("/some/path", "bar") -> error
print fs.read_file("/some/path/to/directory/file") --> prints "foo"
 */