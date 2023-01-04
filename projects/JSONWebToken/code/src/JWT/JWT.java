package code.src.JWT;

import JSONFileReader.JSONFileReader;
import org.apache.log4j.LogManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JWT {
    public static final org.apache.log4j.Logger logger = LogManager.getLogger( JWT.class );

    private static  JSONParser parser = new JSONParser();
    private static JSONObject header = new JSONObject();
    private static JSONObject payload = new JSONObject();
    private static String secretKey = "Secret_of_zafar";
    private static String encodedHeader;
    private static String encodedPayload;
    private static String signature;
    private static JSONObject decodedHeader = new JSONObject();
    private static JSONObject decodedPayload = new JSONObject();
    private static long issuedAtTime = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    private static String JSONWebToken;
    private static long JWTExpiresAt;
    //JWTExpiresAt = LocalDateTime.now().plusSeconds(expiry).toEpochSecond(ZoneOffset.UTC);
    public JWT() throws ParseException, IOException, NoSuchAlgorithmException, InvalidKeyException {
        initialize();
        logger.trace("Creating JWT...");
        logger.trace("JWT created successfully.");
        logger.info("The created JWT is : [ " + createJWT(getEncodedHeader(), getEncodedPayload(), getSignature()) + " ] ");
        setJSONWebToken(createJWT(getEncodedHeader(), getEncodedPayload(), getSignature()));
    }

    public JWT(String JWT) throws NoSuchAlgorithmException, ParseException, InvalidKeyException {
        verifyJWT(JWT);
    }

    public static void initialize() throws IOException, ParseException, NoSuchAlgorithmException, InvalidKeyException {
        setHeader(JSONFileReader.readJsonFile("projects/JSONWebToken/data/json/header.json"));
        setPayload(JSONFileReader.readJsonFile("projects/JSONWebToken/data/json/payload.json"));
        setIssuedAtTimeToPayload();
        encodeHeader(getHeader());
        encodePayload(getPayload());
        createSignature(getEncodedHeader(), getEncodedPayload(), secretKey);
        setJWTExpiresAt(LocalDateTime.now().plusSeconds((long)getPayload().get("eat")).toEpochSecond(ZoneOffset.UTC));
    }

    public static JSONObject getHeader() {
        return header;
    }

    public static JSONObject getPayload() {
        return payload;
    }

    public static String getEncodedHeader() {
        return encodedHeader;
    }

    public static String getEncodedPayload() {
        return encodedPayload;
    }

    public static String getSignature() {
        return signature;
    }

    public static JSONObject getDecodedHeader() {
        return decodedHeader;
    }

    public static JSONObject getDecodedPayload() {
        return decodedPayload;
    }

    public static String getJSONWebToken() {
        return JSONWebToken;
    }

    public static long getJWTExpiresAt() {
        return JWTExpiresAt;
    }

    public static void setJWTExpiresAt(long JWTExpiresAt) {
        JWT.JWTExpiresAt = JWTExpiresAt;
    }

    public static void setHeader(JSONObject header) {
        logger.trace("Setting the value to header...");
        JWT.header = header;
        logger.trace("Value for header set successfully.");
        logger.trace("Printing the values of header...");
        printJSONObjectValues(getHeader());
    }

    public static void setPayload(JSONObject payload) {
        logger.trace("Setting the value to payload...");
        JWT.payload = payload;
        logger.trace("Value for payload set successfully.");
        logger.trace("Printing the values of payload...");
        printJSONObjectValues(getPayload());
    }

    public static void setEncodedHeader(String encodedHeader) {
        logger.trace("Setting the encoded header...");
        JWT.encodedHeader = encodedHeader;
        logger.trace("Header encoded successfully.");
        logger.trace("Encoded header is : [ " + encodedHeader + " ] ");
    }

    public static void setEncodedPayload(String encodedPayload) {
        logger.trace("Setting the encoded payload...");
        JWT.encodedPayload = encodedPayload;
        logger.trace("Payload encoded successfully.");
        logger.trace("Encoded payload is : [ " + encodedPayload + " ] ");
    }

    public static void setSignature(String signature) {
        logger.trace("Setting the signature...");
        JWT.signature = signature;
        logger.trace("Signature set successfully.");
        logger.trace("Signature is : [ " + signature + " ] ");
    }

    public static void setDecodedHeader(JSONObject decodedHeader) {
        logger.trace("Setting the decoded header...");
        JWT.decodedHeader = decodedHeader;
        logger.trace("Decoded header set successfully.");
        logger.trace("Decoded header is : [ " + decodedHeader + " ] ");
    }

    public static void setDecodedPayload(JSONObject decodedPayload) {
        logger.trace("Setting the decoded payload...");
        JWT.decodedPayload = decodedPayload;
        logger.trace("Decoded payload set successfully.");
        logger.trace("Decoded payload is : [ " + decodedPayload + " ] ");
    }

    public static void setIssuedAtTimeToPayload()
    {
        logger.trace("Setting the issued at time to payload...");
        payload.put("iat", issuedAtTime);
        logger.trace("Issued at time set successfully to payload.");
        logger.info("Issued at time is : [ " + issuedAtTime + " ] ");
        logger.trace("Printing payload values after adding issued at time...");
        printJSONObjectValues(getPayload());
    }

    public static void setJSONWebToken(String JSONWebToken) {
        JWT.JSONWebToken = JSONWebToken;
    }

    private static String encode(byte[] bytes) {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    private static String decode(String encodedString) {
        return new String(Base64.getUrlDecoder().decode(encodedString));
    }

    public static void encodeHeader(JSONObject headerObject)
    {
        logger.trace("Encoding the header...");
        setEncodedHeader(encode(headerObject.toString().getBytes(StandardCharsets.UTF_8)));
    }

    public static void encodePayload(JSONObject payloadObject)
    {
        logger.trace("Encoding the payload...");
        setEncodedPayload(encode(payloadObject.toString().getBytes(StandardCharsets.UTF_8)));
    }

    public static String createSignature(String encodedHeader, String encodedPayload, String secretKey) throws NoSuchAlgorithmException, InvalidKeyException
    {
        logger.trace("Creating the signature...");
        try
        {
            String data = encodedHeader + "." + encodedPayload;
            byte[] hash = secretKey.getBytes(StandardCharsets.UTF_8);

            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(hash, "HmacSHA256");
            sha256Hmac.init(secretKeySpec);

            byte[] signedBytes = sha256Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            setSignature(encode(signedBytes));
            return getSignature();
        }
        catch (NoSuchAlgorithmException | InvalidKeyException ex)
        {
            Logger.getLogger(JWT.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            logger.error(ex.getMessage());
            return null;
        }
    }

    public static String createJWT(String encodedHeader, String encodedPayload, String signature)
    {
        return encodedHeader + "." + encodedPayload + "." + signature;
    }

    public static void verifyJWT(String JWT) throws NoSuchAlgorithmException, ParseException, InvalidKeyException
    {
        logger.trace("Verifying JSON Web Token...");
        logger.trace("Splitting the JWT by [.] delimiter...");
        String[] tokenParts = JWT.split("\\.");
        if (tokenParts.length != 3) {
            throw new IllegalArgumentException("Invalid Token format!!!");
        }

        setDecodedHeader((JSONObject) parser.parse(decode(tokenParts[0])));
        if (encodedHeader.equals(tokenParts[0]))
        {
            encodedHeader = tokenParts[0];
        }
        else
        {
            throw new NoSuchAlgorithmException("JWT Header : " + tokenParts[0] + "is Incorrect!!! ");
        }

        setDecodedPayload((JSONObject) parser.parse(decode(tokenParts[1])));
        if (getDecodedPayload().isEmpty()) {
            logger.error("Payload is Empty!!! ");
        }
        if (!getDecodedPayload().containsKey("eat")) {
            logger.error("Payload doesn't contain expiry!!! ");
        }

        if(!(!isJWTExpired((long)getDecodedPayload().get("eat")) && isSignatureValid(tokenParts[0], tokenParts[1])))
        {
            logger.error("The JWT is not valid!!!");
        }
        else
        {
            logger.info("The JWT is valid.");
        }
    }

    public static Boolean isJWTExpired(long expiry)
    {
        logger.info("****************" + JWTExpiresAt);
        if(JWTExpiresAt > LocalDateTime.now().toEpochSecond(ZoneOffset.UTC))
        {
            return  false;
        }
        else
        {
            logger.error("The JWT is expired!!!");
            return true;
        }
    }

    public static Boolean isSignatureValid(String encodedHeader, String encodedPayload) throws NoSuchAlgorithmException, InvalidKeyException {
         if(!signature.equals(createSignature(encodedHeader, encodedPayload, secretKey)))
         {
             logger.error("Signature does not match!!!");
             return false;
         }
         else
             return true;
    }

    public static void printJSONObjectValues(JSONObject jsonObject)
    {
        for (Object key : jsonObject.keySet())
        {
            logger.info("Key : [ " + key + " ], Value : [ " + jsonObject.get(key) + " ] ");
        }
    }
}
