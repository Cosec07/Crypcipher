Set oShell = CreateObject ("Wscript.Shell") 
Dim strArgs
strArgs = "cmd /c Args.bat"
oShell.Run strArgs, 0, false