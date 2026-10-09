$bazo = Split-Path -Parent $MyInvocation.MyCommand.Path
$lib = Join-Path ( Split-Path -Parent ( Split-Path -Parent $bazo ) ) "libraries"
$javac = "C:\Program Files\Microsoft\jdk-25.0.3.9-hotspot\bin\javac.exe"
$jarbin = "C:\Program Files\Microsoft\jdk-25.0.3.9-hotspot\bin\jar.exe"
$cp = @(
  "$lib\io\papermc\paper\paper-api\26.2.build.129-stable\paper-api-26.2.build.129-stable.jar",
  "$lib\net\kyori\adventure-api\5.2.0\adventure-api-5.2.0.jar",
  "$lib\net\kyori\adventure-key\5.2.0\adventure-key-5.2.0.jar",
  "$lib\net\kyori\adventure-text-serializer-plain\5.2.0\adventure-text-serializer-plain-5.2.0.jar",
  "$lib\org\jetbrains\annotations\13.0\annotations-13.0.jar",
  "$lib\com\google\guava\guava\33.6.0-jre\guava-33.6.0-jre.jar",
  "$lib\net\md-5\bungeecord-chat\1.21-R0.2-deprecated+build.21\bungeecord-chat-1.21-R0.2-deprecated+build.21.jar"
) -join ";"
$klaso = Join-Path $bazo "build\classes"
[System.IO.Directory]::CreateDirectory($klaso) | Out-Null
$fontoj = Get-ChildItem -Recurse -LiteralPath ( Join-Path $bazo "src\main\java" ) -Filter "*.java" | Select-Object -ExpandProperty FullName
& $javac -encoding UTF-8 --release 25 -cp "$cp" -d "$klaso" $fontoj
if ( $? ) {
  Copy-Item -LiteralPath ( Join-Path $bazo "src\main\resources\plugin.yml" ) -Destination ( Join-Path $klaso "plugin.yml" ) -Force
  Copy-Item -LiteralPath ( Join-Path $bazo "src\main\resources\config.yml" ) -Destination ( Join-Path $klaso "config.yml" ) -Force
  & $jarbin --create --file ( Join-Path $bazo "build\Hantami.jar" ) -C "$klaso" .
  Write-Output "<( Hantami )> preta en build\Hantami.jar"
} else {
  Write-Output "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) kompilo malsukcesis"
  exit 1
}
