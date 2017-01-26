package com.akiba.djumanji;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class DjumanjiGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture plataformGround;
	Texture plataformBackground;
    Texture plataformCloud;
    Texture plataformCloud2;
    Texture warriorMain;
    Texture monsterMain;
    //Texture monsterMain2;

    BitmapFont goldBitmapFont;
    BitmapFont killBitmapFont;

    ShapeRenderer shapeRenderer;
    Rectangle rectangleWarrior;
    Rectangle rectangleMonster;

    //Variaveis
    int larguraDispositivo = 0;
    int alturaDispositivo = 0;
    int posicaoVerticalNuvem = 0;
    int posicaoHorizontalNuvem = 0;
    int posicaoVerticalNuvem2 = 0;
    int posicaoHorizontalNuvem2 = 0;
    int velocidadeMovimentoNuvem = 0;
    int posicaoHorizontalMonster = 0;
    int posicaoVerticalMonster = 0;
    int velocidadeMovimentoMonster = 0;
    int posicaoHorizontalWarrior = 0;
    int posicaoVerticalWarrior = 0;
    //int posicaoHorizontalMonster2 = 0;
    //int posicaoVerticalMonster2 = 0;
    //int velocidadeMovimentoMonster2 =0;
    int gold = 0;
    int kill = 0;
    int damageWarrior = 2;
    int hpMonster = 15;

    boolean estadoKillPoint = false;
    boolean estadoVelocidaMovimento = false;

    Random random;
	
	@Override
	public void create () {
        //Declarando imagens
		batch = new SpriteBatch();
		plataformGround = new Texture("plataform-ground-mini.png");
        plataformBackground = new Texture("plataform-background.png");
        plataformCloud = new Texture("cloud.png");
        plataformCloud2 = new Texture("cloud.png");
        warriorMain = new Texture("warrior.png");
        monsterMain = new Texture("monster.png");
        //monsterMain2 = new Texture("monster.png");

        rectangleWarrior = new Rectangle();
        rectangleMonster = new Rectangle();

        larguraDispositivo = Gdx.graphics.getHeight();
        alturaDispositivo = Gdx.graphics.getWidth();
        posicaoVerticalNuvem = 1300;
        posicaoHorizontalNuvem = 1000;
        posicaoVerticalNuvem2 = 900;
        posicaoHorizontalNuvem2 = 0;
        velocidadeMovimentoNuvem = 7;

        posicaoHorizontalMonster = larguraDispositivo;
        posicaoVerticalMonster = plataformGround.getHeight();
        velocidadeMovimentoMonster = 20;

        //posicaoHorizontalMonster2 = larguraDispositivo;
        //posicaoVerticalMonster2 = plataformGround.getHeight();
        //velocidadeMovimentoMonster2 = 50;

        posicaoHorizontalWarrior = larguraDispositivo / 8;
        posicaoVerticalWarrior = plataformGround.getHeight();

        random = new Random();

        shapeRenderer = new ShapeRenderer();

        goldBitmapFont = new BitmapFont();
        goldBitmapFont.setColor(Color.WHITE);
        goldBitmapFont.getData().setScale(6);

        killBitmapFont = new BitmapFont();
        killBitmapFont.setColor(Color.WHITE);
        killBitmapFont.getData().setScale(6);

        damageWarrior = kill * 2;
        hpMonster = kill * 3;

	}

	@Override
	public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        posicaoHorizontalNuvem -= velocidadeMovimentoNuvem - 2;
        posicaoHorizontalNuvem2 -= velocidadeMovimentoNuvem;
        if (posicaoHorizontalNuvem < -plataformCloud.getWidth()) {
            posicaoHorizontalNuvem = larguraDispositivo;
        }
        if (posicaoHorizontalNuvem2 < -plataformCloud2.getWidth()) {
            posicaoHorizontalNuvem2 = larguraDispositivo;
        }
        posicaoHorizontalMonster -= velocidadeMovimentoMonster;
        /*if (posicaoHorizontalMonster < - larguraDispositivo) {
            posicaoHorizontalMonster = larguraDispositivo;
            estadoKillPoint = false;
        }*/
        /*posicaoHorizontalMonster2 -= velocidadeMovimentoMonster2;
        if (posicaoHorizontalMonster2 < - larguraDispositivo) {
            posicaoHorizontalMonster2 = larguraDispositivo;
            estadoKillPoint = false;
        }*/

        //Impedir repetição na pontuação
        /*if (posicaoHorizontalWarrior >= posicaoHorizontalMonster) {
            estadoKillPoint = true;
        }*/
        if (estadoVelocidaMovimento) {
            while (posicaoHorizontalMonster < alturaDispositivo / 2) {
                velocidadeMovimentoMonster = 10;
            }
            estadoVelocidaMovimento = false;
        }

        batch.begin();
        batch.draw(plataformBackground, 0, 0);
        batch.draw(plataformGround, 0, 0);
        batch.draw(warriorMain, posicaoHorizontalWarrior, posicaoVerticalWarrior);
        batch.draw(monsterMain, posicaoHorizontalMonster, posicaoVerticalMonster);
        //batch.draw(monsterMain2, posicaoHorizontalMonster2, posicaoVerticalMonster2);
        batch.draw(plataformCloud, posicaoHorizontalNuvem, posicaoVerticalNuvem);
        batch.draw(plataformCloud2, posicaoHorizontalNuvem2, posicaoVerticalNuvem2);

        killBitmapFont.draw(batch, "Kills: " + String.valueOf(kill), 90, 1700);
        goldBitmapFont.draw(batch, "Gold: " + String.valueOf(gold), 90, 1600);

        batch.end();

        rectangleWarrior = new Rectangle(
                posicaoHorizontalWarrior, posicaoVerticalWarrior, warriorMain.getWidth(), warriorMain.getHeight()
        );
        rectangleMonster = new Rectangle(
                posicaoHorizontalMonster, posicaoVerticalMonster, monsterMain.getWidth(), monsterMain.getHeight()
        );

        /*shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(rectangleWarrior.x, rectangleWarrior.y, rectangleWarrior.getWidth(), rectangleWarrior.getHeight());
        shapeRenderer.rect(rectangleMonster.x, rectangleMonster.y, rectangleMonster.getWidth(), rectangleMonster.getHeight());
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.end();*/

        if (Intersector.overlaps(rectangleWarrior, rectangleMonster)) {
            //if (!estadoKillPoint) {
            gold += random.nextInt(500);
            kill++;
            //posicaoHorizontalMonster = larguraDispositivo - 800;
            //estadoKillPoint = true;
            //if (hpMonster <= 0) {
                //posicaoHorizontalMonster = larguraDispositivo;
            //} else {
                //hpMonster ++;
                velocidadeMovimentoMonster = -10;
                estadoVelocidaMovimento = true;
                //if (posicaoHorizontalMonster < 900) {
                    //velocidadeMovimentoMonster = 20;
                //}

            /*while (hpMonster >= 0) {
                hpMonster -= damageWarrior;

            }*/

        }
    }
	
	@Override
	public void dispose () {
		batch.dispose();
		plataformGround.dispose();
        plataformBackground.dispose();
        plataformCloud.dispose();
        plataformCloud2.dispose();
        warriorMain.dispose();
        monsterMain.dispose();
        goldBitmapFont.dispose();
        killBitmapFont.dispose();
	}
}
